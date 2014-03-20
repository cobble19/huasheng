Ext.define('HS.store.FragmentStore', {
	extend: 'Ext.data.Store',
	model: 'HS.model.FragmentModel',
	autoLoad: false,
	proxy: {
		type: 'ajax',
		actionMethods: {
			read: 'POST'
		},
		api: {
			read: Ext.get('contextPath').dom.value + '/json/handleUrl!fragment'
		},
		reader: {
			type: 'json',
			root: 'fragmentDTOList',
			successProperty: 'success'
		}
	}
})