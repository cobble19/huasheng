Ext.define('HS.model.ItemModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'itemId', type: 'long', convert: null},
		{name: 'name', type: 'string'},
		{name: 'hits', type: 'long', convert: null},
		{name: 'areaName', type: 'string'},
		{name: 'showDate', type: 'date'},
		{name: 'score', type: 'double'},
		{name: 'description', type: 'string'},
		{name: 'actorName', type: 'string'},
		{name: 'itemType', type: 'string'},
		{name: 'categoryDTO.categoryId', type: 'long'}
	]
})