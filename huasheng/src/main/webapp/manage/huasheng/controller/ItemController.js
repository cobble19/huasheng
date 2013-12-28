Ext.define('HS.controller.ItemController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['ItemStore'],
	models: ['ItemModel'],
	views: ['item.List','item.Edit', 'comboBox.CategoryComboBox'],
	refs: [{
		ref: 'itemList',
		selector: 'viewport itemlist'
	}],
	init: function() {
		this.control({
			'viewport itemlist button[action=add]': {
				click: this.openDialog4Add
			},
			'itemedit button[action=add]': {
				click: this.addItem
			},
			'viewport itemlist button[action=update]': {
				click: this.openDialog4Update
			},
			'itemedit button[action=update]': {
				click: this.updateItem
			},
			'viewport itemlist button[action=delete]': {
				click: this.openDialog4Delete
			}
		});
	},
	openDialog4Add: function(button) {
		console.log('open dialog for add');
		var view = Ext.widget('itemedit');
		// hide update button
		var btns = Ext.query('a[id=btnUpdate]');
		Ext.each(btns, function(btn) {
			Ext.get(btn).hide();
		});
		// hide id input
		var inputId = Ext.query('input[name=itemId]');
		Ext.get(inputId).hide();
	},
	addItem: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm();
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/item!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				var itemDTO = action.result.itemDTO;
				var encode = Ext.JSON.encode(itemDTO);
				var decode = Ext.JSON.decode(encode);
				var record = Ext.create('HS.model.ItemModel', {
					itemId: itemDTO.itemId,
					name: itemDTO.name,
					'categoryDTO.categoryId': itemDTO.categoryDTO.categoryId
				});
				var index = 0;
				var records = Ext.getStore('ItemStore').insert(index, record);
				// change color
				me.getItemList().getView().addRowCls(record, 'red');
				/*var tr = Ext.query('tr[data-recordindex=' + index + ']');
				Ext.get(tr).addCls('red');*/
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
	},
	openDialog4Update: function(button) {
		var grid = button.up('itemlist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('Alarm', 'Please select ONE row!');
			return;
		} else {
			// display edit window
			var view = Ext.widget('itemedit');
			// hide add button
			var btns = Ext.query('a[id=btnAdd]');
			Ext.each(btns, function(btn){
				Ext.get(btn).hide();
			});
			// load rowdata that will be updated 
			view.down('form').loadRecord(records[0]);
		}
	},
	updateItem: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm(),
			record = form.getRecord();
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/item!update',
			method: 'POST',
			success: function(form, action) {
				record = form.getRecord();
				record.set(form.getValues());
				record.commit();
				// 1. set record, 2. close it.
				win.close();
				// change color
				me.getItemList().getView().addRowCls(record, 'red');
				/*var tr = Ext.query('tr[data-recordindex=' + record.index + ']');
				Ext.get(tr).addCls('red');*/
			},
			failure: function(form, action) {
				Ext.MessageBox.alert('Alarm', action.response.statusText);
			}
		})
	},
	openDialog4Delete: function(button) {
		var grid = button.up('itemlist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		var deleteItem = this.deleteItem;
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
						deleteItem(records);
						return;
					} else {
						return;
					}
				}
			});
		}
	},
	deleteItem: function(records) {
		var ids = [];
		Ext.each(records, function(record) {
			ids.push(record.get('itemId'));
		});
		params = {
			'ids': ids.join(',')
		};
		Ext.Ajax.request({
			url: Ext.get('contextPath').dom.value + '/json/item!delete',
			method: 'POST',
			params: params,
			success: function(response, options) {
				Ext.Array.each(records, function(record){
					Ext.getStore('ItemStore').remove(record);
				});
				Ext.MessageBox.alert('Info', 'Deleted successfully!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('Alarm', 'Deleted fail!');
			}
		});
	}
})