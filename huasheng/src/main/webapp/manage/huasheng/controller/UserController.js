Ext.define('HS.controller.UserController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['UserStore'],
	models: ['UserModel'],
	views: ['user.List','user.Edit', 'user.EditPwd', 'checkbox.RoleCheckboxGroup'],
	refs: [{
		ref: 'userList',
		selector: 'viewport userlist'
	}],
	init: function() {
		this.control({
			'viewport userlist button[action=search]': {
				click: this.searchUser
			},
			'viewport userlist button[action=add]': {
				click: this.openDialog4Add
			},
			'useredit button[action=add]': {
				click: this.addUser
			},
			'viewport userlist button[action=update]': {
				click: this.openDialog4Update
			},
			'useredit button[action=update]': {
				click: this.updateUser
			},
			'viewport userlist button[action=delete]': {
				click: this.openDialog4Delete
			},
			'viewport userlist button[action=changePwd]': {
				click: this.openDialog4ChangePwd
			},
			'usereditpwd button[action=changePwd]': {
				click: this.changePwd
			},
		});
	},
	searchUser: function(button) {
		var userNameEle = Ext.ComponentQuery.query('panel textfield[name=userEntitySearch.userName]')[0];
		userName = userNameEle.getValue();
		var store = this.getUserStoreStore();
		store.load({
			params: {
	            'userEntitySearch.userName': userName
	        }
		});
		console.log('searchUser...' + userName);
	},
	openDialog4Add: function(button) {
		console.log('open dialog for add');
		var view = Ext.widget('useredit');
		// hide update button
		var btns = Ext.query('a[id=btnUpdate]');
		Ext.each(btns, function(btn) {
			Ext.get(btn).hide();
		});
		// hide id input
		var inputId = Ext.query('input[name=userId]');
		Ext.get(inputId).hide();
	},
	addUser: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm();
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/user!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				var userEntity = action.result.userEntity;
				var record = Ext.create('HS.model.UserModel', {
					userId: userEntity.userId,
					userName: userEntity.userName
				});
				var index = 0;
				var records = Ext.getStore('UserStore').insert(index, record);
				// change color
				me.getUserList().getView().addRowCls(record, 'red');
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
	},
	openDialog4Update: function(button) {
		var grid = button.up('userlist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('警告', '请选择一条记录!');
			return;
		} else {
			// display edit window
			var view = Ext.widget('useredit');
			// hide password modify text
			var passwords = Ext.query('input[name=password]');
			passItem = Ext.ComponentQuery.query('panel textfield[name=password]')[0];
			passItem.allowBlank=true;
			passItem.clearInvalid();
			
			Ext.each(passwords, function(password){
				Ext.get(password).parent().parent().parent().parent().hide();
			});
			// hide add button
			var btns = Ext.query('a[id=btnAdd]');
			Ext.each(btns, function(btn){
				Ext.get(btn).hide();
			});
			// load rowdata that will be updated 
			view.down('form').loadRecord(records[0]);
		}
	},
	updateUser: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm(),
			record = form.getRecord();
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/user!update',
			method: 'POST',
			success: function(form, action) {
				record = form.getRecord();
				record.set(form.getValues());
				record.commit();
				// 1. set record, 2. close it.
				win.close();
				// change color
				me.getUserList().getView().addRowCls(record, 'red');
			},
			failure: function(form, action) {
				Ext.MessageBox.alert('警告', "failure");
			}
		});
	},
	openDialog4Delete: function(button) {
		var grid = button.up('userlist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		var deleteUser = this.deleteUser;
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
						deleteUser(records);
						return;
					} else {
						return;
					}
				}
			});
		}
	},
	deleteUser: function(records) {
		var ids = [];
		Ext.each(records, function(record) {
			ids.push(record.get('userId'));
		});
		params = {
			'ids': ids.join(',')
		};
		Ext.Ajax.request({
			url: Ext.get('contextPath').dom.value + '/json/user!delete',
			method: 'POST',
			params: params,
			success: function(response, options) {
				Ext.Array.each(records, function(record){
					Ext.getStore('UserStore').remove(record);
				});
				Ext.MessageBox.alert('信息', '删除成功!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('警告', '删除失败!');
			}
		});
	},
	openDialog4ChangePwd: function(button) {
		var grid = button.up('userlist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('警告', '请选择一条记录!');
			return;
		} else {
			// display edit window
			var view = Ext.widget('usereditpwd');
			// load rowdata that will be updated 
			view.down('form').loadRecord(records[0]);
		}
	},
	changePwd: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm(),
			record = form.getRecord();
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/user!changePwd',
			method: 'POST',
			success: function(form, action) {
				record = form.getRecord();
				record.set(form.getValues());
				record.commit();
				// 1. set record, 2. close it.
				win.close();
				// change color
				me.getUserList().getView().addRowCls(record, 'red');
			},
			failure: function(form, action) {
				Ext.MessageBox.alert('警告', action);
			}
		})
	}
})