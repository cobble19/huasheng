Ext.define('HS.controller.PrivilegeController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['PrivilegeStore'],
	models: ['PrivilegeModel'],
	views: ['privilege.List','privilege.Edit'],
	refs: [{
		ref: 'privilegeList',
		selector: 'viewport privilegelist'
	}],
	init: function() {
		this.control({
			'viewport privilegelist button[action=search]': {
				click: this.searchPrivilege
			},
			'viewport privilegelist button[action=add]': {
				click: this.openDialog4Add
			},
			'privilegeedit button[action=add]': {
				click: this.addPrivilege
			},
			'viewport privilegelist button[action=update]': {
				click: this.openDialog4Update
			},
			'privilegeedit button[action=update]': {
				click: this.updatePrivilege
			},
			'viewport privilegelist button[action=delete]': {
				click: this.openDialog4Delete
			}
		});
	},
	searchPrivilege: function(button) {
		var resourceEle = Ext.ComponentQuery.query('panel textfield[name=privilegeEntitySearch.resource]')[0];
		resource = resourceEle.getValue();
		var store = this.getPrivilegeStoreStore();
		store.load({
			params: {
	            'privilegeEntitySearch.resource': resource
	        }
		});
		console.log('searchPrivilege...' + resource);
	},
	openDialog4Add: function(button) {
		console.log('open dialog for add');
		var view = Ext.widget('privilegeedit');
		// hide update button
		var btns = Ext.query('a[id=btnUpdate]');
		Ext.each(btns, function(btn) {
			Ext.get(btn).hide();
		});
		// hide id input
		var inputId = Ext.query('input[name=privilegeId]');
		Ext.get(inputId).hide();
	},
	addPrivilege: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm();
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/privilege!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				var privilegeEntity = action.result.privilegeEntity;
				var record = Ext.create('HS.model.PrivilegeModel', {
					privilegeId: privilegeEntity.privilegeId,
					resource: privilegeEntity.resource
				});
				var index = 0;
				var records = Ext.getStore('PrivilegeStore').insert(index, record);
				// change color
				me.getPrivilegeList().getView().addRowCls(record, 'red');
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
	},
	openDialog4Update: function(button) {
		var grid = button.up('privilegelist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('警告', '请选择一条记录!');
			return;
		} else {
			// display edit window
			var view = Ext.widget('privilegeedit');
			// hide add button
			var btns = Ext.query('a[id=btnAdd]');
			Ext.each(btns, function(btn){
				Ext.get(btn).hide();
			});
			// load rowdata that will be updated 
			view.down('form').loadRecord(records[0]);
		}
	},
	updatePrivilege: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm(),
			record = form.getRecord();
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/privilege!update',
			method: 'POST',
			success: function(form, action) {
				record = form.getRecord();
				record.set(form.getValues());
				record.commit();
				// 1. set record, 2. close it.
				win.close();
				// change color
				me.getPrivilegeList().getView().addRowCls(record, 'red');
			},
			failure: function(form, action) {
				Ext.MessageBox.alert('警告', action.response.statusText);
			}
		})
	},
	openDialog4Delete: function(button) {
		var grid = button.up('privilegelist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		var deletePrivilege = this.deletePrivilege;
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
						deletePrivilege(records);
						return;
					} else {
						return;
					}
				}
			});
		}
	},
	deletePrivilege: function(records) {
		var ids = [];
		Ext.each(records, function(record) {
			ids.push(record.get('privilegeId'));
		});
		params = {
			'ids': ids.join(',')
		};
		Ext.Ajax.request({
			url: Ext.get('contextPath').dom.value + '/json/privilege!delete',
			method: 'POST',
			params: params,
			success: function(response, options) {
				Ext.Array.each(records, function(record){
					Ext.getStore('PrivilegeStore').remove(record);
				});
				Ext.MessageBox.alert('信息', '删除成功!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('警告', '删除失败!');
			}
		});
	}
})