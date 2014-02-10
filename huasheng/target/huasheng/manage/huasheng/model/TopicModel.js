Ext.define('HS.model.TopicModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'topicId', type: 'long', convert: null},
		{name: 'name', type: 'string'}
	]
})