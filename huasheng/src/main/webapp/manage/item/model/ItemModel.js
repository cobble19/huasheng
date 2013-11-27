Ext.define('ITEM.model.ItemModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'itemId', type: 'long', convert: null},
		{name: 'name', type: 'string'},
		{name: 'categoryDTO.categoryId', type: 'long'}
	]
})