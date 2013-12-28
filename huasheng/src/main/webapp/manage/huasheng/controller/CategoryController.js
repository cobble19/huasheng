Ext.define('HS.controller.CategoryController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['CategoryStore'],
	models: ['CategoryModel'],
	views: ['category.List', 'category.Edit', 'comboBox.TopicComboBox'],
	refs: [{
		ref: 'categoryList',
		selector: 'viewport categorylist'
	}],
	init: function() {
		this.control({
			'viewport categorylist button[action=add]': {
				click: this.openDialog4Add
			},
			'categoryedit button[action=add]': {
				click: this.addCategory
			},
			'viewport categorylist button[action=update]': {
				click: this.openDialog4Update
			},
			'categoryedit button[action=update]': {
				click: this.updateCategory
			},
			'viewport categorylist button[action=delete]': {
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
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/category!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				var categoryDTO = action.result.categoryDTO;
				var record = Ext.create('HS.model.CategoryModel', {
					categoryId: categoryDTO.categoryId,
					name: categoryDTO.name,
					'topicDTO.topicId': categoryDTO.topicDTO.topicId
				});
				var index = 0;
				var records = Ext.getStore('CategoryStore').insert(index, record);
				// change color
				me.getCategoryList().getView().addRowCls(record, 'red');
				/*var tr = Ext.query('tr[data-recordindex=' + index + ']');
				Ext.get(tr).addCls('red');*/
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
			Ext.MessageBox.alert('警告', '请选择一条记录!');
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
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/category!update',
			method: 'POST',
			success: function(form, action) {
				record = form.getRecord();
				record.set(form.getValues());
				record.commit();
				// 1. set record, 2. close it.
				win.close();
				// change color
				me.getCategoryList().getView().addRowCls(record, 'red');
				/*var tr = Ext.query('tr[data-recordindex=' + record.index + ']');
				Ext.get(tr).addCls('red');*/
			},
			failure: function(form, action) {
				Ext.MessageBox.alert('警告', action.response.statusText);
			}
		})
	},
	openDialog4Delete: function(button) {
		var grid = button.up('categorylist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		var deleteCategory = this.deleteCategory;
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('警告', '请选择一条记录!');
			return;
		} else {
			Ext.MessageBox.show({
				title: '确认提示',
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
				Ext.MessageBox.alert('Info', '删除成功!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('警告', '删除失败!');
			}
		});
	}
})