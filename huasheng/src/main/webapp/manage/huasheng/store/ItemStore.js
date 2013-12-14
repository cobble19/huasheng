Ext.define('HS.store.ItemStore', {
	extend: 'Ext.data.Store',
	model: 'HS.model.ItemModel',
	autoLoad: true,
	proxy: {
		type: 'ajax',
		api: {
			read: Ext.get('contextPath').dom.value + '/json/item!execute',
			update: Ext.get('contextPath').dom.value + '/json/item!update',
			create: '',
			destroy: ''
		},
		reader: {
			type: 'json',
			root: 'itemDTOList',
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