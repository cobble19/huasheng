Ext.define('CATEG.store.CategoryStore', {
	extend: 'Ext.data.Store',
	model: 'CATEG.model.CategoryModel',
	autoLoad: true,
	proxy: {
		type: 'ajax',
		api: {
			read: Ext.get('contextPath').dom.value + '/json/category!execute',
			update: Ext.get('contextPath').dom.value + '/json/category!update',
			create: '',
			destroy: ''
		},
		reader: {
			type: 'json',
			root: 'categoryDTOList',
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