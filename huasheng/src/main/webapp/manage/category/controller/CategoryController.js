Ext.define('CATEG.controller.CategoryController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['CategoryStore'],
	models: ['CategoryModel'],
	views: ['category.List', 'category.Edit'],
	init: function() {
		this.control({
			'viewport > categorylist button[action=add]': {
				click: this.openDialog4Add
			},
			'categoryedit button[action=add]': {
				click: this.addCategory
			},
			'viewport > categorylist button[action=update]': {
				click: this.openDialog4Update
			},
			'categoryedit button[action=update]': {
				click: this.updateCategory
			},
			'viewport > categorylist button[action=delete]': {
				click: this.openDialog4Delete
			}
		});
	},
	openDialog4Add: function(button) {
		console.log('open dialog for add');
		var view = Ext.widget('categoryedit');
		// hide update button
		var btns = Ext.query('a[id=btnUpdate]');
		Ext.each(btns, function(btn) {
			Ext.get(btn).hide();
		});
		// hide id input
		var inputId = Ext.query('input[name=categoryId]');
		Ext.get(inputId).hide();
	},
	addCategory: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/category!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				var categoryDTO = action.result.categoryDTO;
				var index = 0;
				var records = Ext.getStore('CategoryStore').insert(index, categoryDTO);
				// change color
				var tr = Ext.query('tr[data-recordindex=' + index + ']');
				Ext.get(tr).addCls('red');
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
	},
	openDialog4Update: function(button) {
		var grid = button.up('categorylist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('Alarm', 'Please select ONE row!');
			return;
		} else {
			// display edit window
			var view = Ext.widget('categoryedit');
			// hide add button
			var btns = Ext.query('a[id=btnAdd]');
			Ext.each(btns, function(btn){
				Ext.get(btn).hide();
			});
			// load rowdata that will be updated 
			view.down('form').loadRecord(records[0]);
		}
	},
	updateCategory: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm(),
			record = form.getRecord();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/category!update',
			method: 'POST',
			success: function(form, action) {
				
			},
			failure: function(form, action) {
				Ext.MessageBox.alert('Alarm', action.response.statusText);
			}
		})
	},
	openDialog4Delete: function(button) {
		var grid = button.up('categorylist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		var deleteCategory = this.deleteCategory;
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('Alarm', 'Please select ONE row!');
			return;
		} else {
			Ext.MessageBox.show({
				title: 'Confirm',
				icon: Ext.MessageBox.WARNING,
				msg: '确认删除数据？',
				buttons: Ext.MessageBox.OKCANCEL,
				fn: function(buttonId, text, opt) {
					if ('ok' == buttonId) {
						deleteCategory(records);
						return;
					} else {
						return;
					}
				}
			});
		}
	},
	deleteCategory: function(records) {
		var ids = [];
		Ext.each(records, function(record) {
			ids.push(record.get('categoryId'));
		});
		params = {
			'ids': ids.join(',')
		};
		Ext.Ajax.request({
			url: Ext.get('contextPath').dom.value + '/json/category!delete',
			method: 'POST',
			params: params,
			success: function(response, options) {
				Ext.Array.each(records, function(record){
					Ext.getStore('CategoryStore').remove(record);
				});
				Ext.MessageBox.alert('Info', 'Deleted successfully!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('Alarm', 'Deleted fail!');
			}
		});
	}
})