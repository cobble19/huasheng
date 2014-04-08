Ext.define('HS.controller.RoleController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['RoleStore'],
	models: ['RoleModel'],
	views: ['role.List','role.Edit', 'checkbox.PrivilegeCheckboxGroup'],
	refs: [{
		ref: 'roleList',
		selector: 'viewport rolelist'
	}],
	init: function() {
		this.control({
			'viewport rolelist button[action=search]': {
				click: this.searchRole
			},
			'viewport rolelist button[action=add]': {
				click: this.openDialog4Add
			},
			'roleedit button[action=add]': {
				click: this.addRole
			},
			'viewport rolelist button[action=update]': {
				click: this.openDialog4Update
			},
			'roleedit button[action=update]': {
				click: this.updateRole
			},
			'viewport rolelist button[action=delete]': {
				click: this.openDialog4Delete
			}
		});
	},
	searchRole: function(button) {
		var roleNameEle = Ext.ComponentQuery.query('panel textfield[name=roleEntitySearch.roleName]')[0];
		roleName = roleNameEle.getValue();
		var store = this.getRoleStoreStore();
		store.load({
			params: {
	            'roleEntitySearch.roleName': roleName
	        }
		});
		console.log('searchRole...' + roleName);
	},
	openDialog4Add: function(button) {
		console.log('open dialog for add');
		var view = Ext.widget('roleedit');
		// hide update button
		var btns = Ext.query('a[id=btnUpdate]');
		Ext.each(btns, function(btn) {
			Ext.get(btn).hide();
		});
		// hide id input
		var inputId = Ext.query('input[name=roleId]');
		Ext.get(inputId).hide();
	},
	addRole: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm();
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/role!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				var roleEntity = action.result.roleEntity;
				var record = Ext.create('HS.model.RoleModel', {
					roleId: roleEntity.roleId,
					roleName: roleEntity.roleName
				});
				var index = 0;
				var records = Ext.getStore('RoleStore').insert(index, record);
				// change color
				me.getRoleList().getView().addRowCls(record, 'red');
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
	},
	openDialog4Update: function(button) {
		var grid = button.up('rolelist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('警告', '请选择一条记录!');
			return;
		} else {
			// display edit window
			var view = Ext.widget('roleedit');
			// hide add button
			var btns = Ext.query('a[id=btnAdd]');
			Ext.each(btns, function(btn){
				Ext.get(btn).hide();
			});
			// load rowdata that will be updated 
			view.down('form').loadRecord(records[0]);
		}
	},
	updateRole: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm(),
			record = form.getRecord();
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/role!update',
			method: 'POST',
			success: function(form, action) {
				record = form.getRecord();
				record.set(form.getValues());
				record.commit();
				// 1. set record, 2. close it.
				win.close();
				// change color
				me.getRoleList().getView().addRowCls(record, 'red');
			},
			failure: function(form, action) {
				Ext.MessageBox.alert('警告', action.response.statusText);
			}
		})
	},
	openDialog4Delete: function(button) {
		var grid = button.up('rolelist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		var deleteRole = this.deleteRole;
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
						deleteRole(records);
						return;
					} else {
						return;
					}
				}
			});
		}
	},
	deleteRole: function(records) {
		var ids = [];
		Ext.each(records, function(record) {
			ids.push(record.get('roleId'));
		});
		params = {
			'ids': ids.join(',')
		};
		Ext.Ajax.request({
			url: Ext.get('contextPath').dom.value + '/json/role!delete',
			method: 'POST',
			params: params,
			success: function(response, options) {
				Ext.Array.each(records, function(record){
					Ext.getStore('RoleStore').remove(record);
				});
				Ext.MessageBox.alert('信息', '删除成功!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('警告', '删除失败!');
			}
		});
	}
})