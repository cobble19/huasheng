Ext.define('HS.model.ItemModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'itemId', type: 'long', convert: null},
		{name: 'name', type: 'string'},
		{name: 'hits', type: 'long', convert: null},
		{name: 'areaName', type: 'string'},
		{name: 'showDate', type: 'date'},
		{name: 'year', type: 'int'},
		{name: 'score', type: 'double'},
		{name: 'description', type: 'string'},
		{name: 'actorName', type: 'string'},
		{name: 'itemType', type: 'string'},
		{name: 'director', type: 'string'},
		{name: 'imgUrl', type: 'string'},
		{name: 'upload', type: 'string'},
		{name: 'categoryDTO.categoryId', type: 'long'}
	]
})