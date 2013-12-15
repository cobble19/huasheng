Ext.define('HS.view.content.Panel', {
	extend: 'Ext.panel.Panel',
	alias: 'widget.contentpanel',
	id: 'content-panel',
	region: 'center',
	layout: 'card',
	margins: '2 5 5 0',
	activeItem: 0,
	border: false,
	items: [{
		xtype: 'topiclist'
	}, {
		xtype: 'categorylist'
	}, {
		xtype: 'itemlist'
	}, {
		xtype: 'videosrclist'
	}, {
		xtype: 'videolist'
	}]
})