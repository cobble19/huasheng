Ext.define('HS.model.ContentModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'itemId', type: 'long', convert: null},
		{name: 'name', type: 'string'},
		{name: 'categoryDTO.categoryId', type: 'long'}
	]
})