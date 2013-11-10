Ext.define('CATEG.model.CategoryModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'categoryId', type: 'long', convert: null},
		{name: 'name', type: 'string'},
		{name: 'topicDTO.topicId', type: 'long'}
	]
})