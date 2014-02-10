Ext.define('TPC.model.TopicModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'topicId', type: 'long', convert: null},
		{name: 'name', type: 'string'}
	]
})