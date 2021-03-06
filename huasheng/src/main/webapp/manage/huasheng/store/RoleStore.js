Ext.define('HS.store.RoleStore', {
	extend: 'Ext.data.Store',
	model: 'HS.model.RoleModel',
	autoLoad: false,
	pageSize: 20,
	proxy: {
		type: 'ajax',
		actionMethods: {
			read: 'POST'
		},
		api: {
			read: Ext.get('contextPath').dom.value + '/json/role!execute',
			update: Ext.get('contextPath').dom.value + '/json/role!update',
			create: '',
			destroy: ''
		},
		reader: {
			type: 'json',
			root: 'roleEntityList',
			successProperty: 'success'
		},
		writer: {
			encode: true,
			root: 'updatedStr'
		}
	},
	listeners: {
		update: function(store, record, operation, modifiedFieldNames, eOpts) {
			console.log("record been updated." + 'operation:' + operation);
		},
		add: function(store, records, index, eOpts) {
			console.log('record been added. index=' + index);
		},
		load: function( store, records, successful, eOpts ) {
			console.log(store + "-" + records + "-" + successful + "-" + eOpts);
			if (!successful) {
				window.location.href = Ext.get('contextPath').dom.value + "/manage/login.jsp";
			}
		}
	}
})