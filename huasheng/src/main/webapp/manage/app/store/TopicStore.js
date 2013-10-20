Ext.define('MNG.store.TopicStore', {
	extend: 'Ext.data.Store',
	/*fields: ['topicId', 'name'],*/
	model: 'MNG.model.TopicModel',
	/*data: [
		{topicId: 1, name: 'TopicName1'},
		{topicId: 2, name: 'topicName2'}
	]*/
	autoLoad: true,
	proxy: {
		type: 'ajax',
		/*url: Ext.get('contextPath').dom.value + '/json/topic!execute',*/
		api: {
			read: Ext.get('contextPath').dom.value + '/json/topic!execute',
			update: Ext.get('contextPath').dom.value + '/json/topic!update',
			create: '',
			destroy: ''
		},
		reader: {
			type: 'json',
			root: 'topicDTOList',
			successProperty: 'success'
		},
		writer: {
            encode: true,
            root: 'updatedStr'
        }
	}
})