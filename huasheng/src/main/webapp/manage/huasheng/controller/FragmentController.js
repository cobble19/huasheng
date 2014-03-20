Ext.define('HS.controller.FragmentController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['FragmentStore'],
	models: ['FragmentModel'],
	views: ['fragment.List','fragment.Edit', 'comboBox.CategoryComboBox'],
	refs: [{
		ref: 'fragmentList',
		selector: 'viewport fragmentlist'
	}],
	init: function() {
		this.control({
			'viewport fragmentlist button[action=add]': {
				click: this.openDialog4Add
			},
			'fragmentedit button[action=add]': {
				click: this.addFragment
			},
			'viewport fragmentlist button[action=update]': {
				click: this.openDialog4Update
			},
			'fragmentedit button[action=update]': {
				click: this.updateFragment
			},
			'viewport fragmentlist button[action=delete]': {
				click: this.openDialog4Delete
			}
		});
	},
	openDialog4Add: function(button) {
		console.log('open dialog for add');
		var view = Ext.widget('fragmentedit');
		// hide update button
		var btns = Ext.query('a[id=btnUpdate]');
		Ext.each(btns, function(btn) {
			Ext.get(btn).hide();
		});
		// hide id input
		var inputId = Ext.query('input[name=itemId]');
		Ext.get(inputId).hide();
	},
	addFragment: function(button) {
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
				var record = Ext.create('HS.model.FragmentModel', {
					itemId: itemDTO.itemId,
					name: itemDTO.name,
					'categoryDTO.categoryId': itemDTO.categoryDTO.categoryId
				});
				var index = 0;
				var records = Ext.getStore('FragmentStore').insert(index, record);
				// change color
				me.getFragmentList().getView().addRowCls(record, 'red');
				/*var tr = Ext.query('tr[data-recordindex=' + index + ']');
				Ext.get(tr).addCls('red');*/
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
	},
	openDialog4Update: function(button) {
		var grid = button.up('fragmentlist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('警告', '请选择一条记录!');
			return;
		} else {
			// display edit window
			var view = Ext.widget('fragmentedit');
			// hide add button
			var btns = Ext.query('a[id=btnAdd]');
			Ext.each(btns, function(btn){
				Ext.get(btn).hide();
			});
			var record = records[0];
			// load rowdata that will be updated 
			view.down('form').loadRecord(record);
		}
	},
	updateFragment: function(button) {
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
				var cmp = Ext.getCmp('upload');
				var v = cmp.getValue();
				v = cmp.getRawValue();
				v = action.result.itemDTO.imgUrl;
				record.set('imgUrl', v);
				record.commit();
				// 1. set record, 2. close it.
				win.close();
				// change color
				me.getFragmentList().getView().addRowCls(record, 'red');
				/*var tr = Ext.query('tr[data-recordindex=' + record.index + ']');
				Ext.get(tr).addCls('red');*/
			},
			failure: function(form, action) {
				Ext.MessageBox.alert('警告', action.response.statusText);
			}
		})
	},
	openDialog4Delete: function(button) {
		var grid = button.up('fragmentlist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		var deleteFragment = this.deleteFragment;
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
						deleteFragment(records);
						return;
					} else {
						return;
					}
				}
			});
		}
	},
	deleteFragment: function(records) {
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
					Ext.getStore('FragmentStore').remove(record);
				});
				Ext.MessageBox.alert('信息', '删除成功!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('警告', '删除失败!');
			}
		});
	}
})