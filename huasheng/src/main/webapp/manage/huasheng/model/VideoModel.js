Ext.define('HS.model.VideoModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'videoId', type: 'long', convert: null},
		{name: 'name', type: 'string'},
		{name: 'url', type: 'string'},
		{name: 'orderNum', type: 'int'},
		{name: 'title', type: 'string'},
		{name: 'text', type: 'string'},
		{name: 'target', type: 'string'},
		{name: 'itemDTO.itemId', type: 'long'},
		{name: 'videoSrcDTO.videoSrcId', type: 'long'}
	]
})