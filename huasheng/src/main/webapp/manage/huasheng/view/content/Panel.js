Ext.define('HS.view.content.Panel', {
	extend: 'Ext.panel.Panel',
	alias: 'widget.contentpanel',
	id: 'content-panel',
	region: 'center',
	layout: 'card',
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
	}, {
		xtype: 'fragmentlist'
	}, {
		xtype: 'rolelist'
	}, {
		xtype: 'privilegelist'
	}, {
		xtype: 'userlist'
	}]
})