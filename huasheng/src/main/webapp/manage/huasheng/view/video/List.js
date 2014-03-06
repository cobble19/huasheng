Ext.define('HS.view.video.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.videolist',
	
	title: '视频列表',
	id: 'video-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'VideoStore',
	tbar: [
	{
		xtype: 'button',
		text: '添加',
		action: 'add'
	},
	{
		xtype: 'button',
		text: '修改',
		action: 'update'
	},
	{
		xtype: 'button',
		text: '删除',
		action: 'delete'
	}
	],
	initComponent: function() {
		this.columns = [
		{
			xtype: 'rownumberer',
			align: 'center',
			text: '行号',
			width: '40'
		},
		{
			header: '视频唯一标识',
			dataIndex: 'videoId',
			flex: 1
		}, 
		{
			header: '名称',
			dataIndex: 'name',
			flex: 1
		}, 
		{
			header: '视频URL',
			dataIndex: 'url',
			flex: 1
		}, 
		{
			header: '视频排序',
			dataIndex: 'orderNum',
			flex: 1
		}, 
		{
			header: '影视唯一标识',
			dataIndex: 'itemDTO.itemId',
			flex: 1
		}, 
		{
			header: '视频源唯一标识',
			dataIndex: 'videoSrcDTO.videoSrcId',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})