Ext.define('HS.store.VideoStore', {
	extend: 'Ext.data.Store',
	model: 'HS.model.VideoModel',
	autoLoad: false,
	pageSize: 10,
	proxy: {
		type: 'ajax',
		actionMethods: {
			read: 'POST'
		},
		api: {
			read: Ext.get('contextPath').dom.value + '/json/video!execute',
			update: Ext.get('contextPath').dom.value + '/json/video!update',
			create: '',
			destroy: ''
		},
		reader: {
			type: 'json',
			root: 'videoDTOList',
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
		}
	}
})