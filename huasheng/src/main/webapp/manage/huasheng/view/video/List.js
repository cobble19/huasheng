Ext.define('HS.view.video.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.videolist',
	
	title: 'Video List',
	id: 'video-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'VideoStore',
	tbar: [
	{
		xtype: 'button',
		text: 'Add',
		action: 'add'
	},
	{
		xtype: 'button',
		text: 'Update',
		action: 'update'
	},
	{
		xtype: 'button',
		text: 'Delete',
		action: 'delete'
	}
	],
	initComponent: function() {
		this.columns = [
		{
			xtype: 'rownumberer',
			align: 'center',
			text: 'RowNum',
			width: '40'
		},
		{
			header: 'Video Id',
			dataIndex: 'videoId',
			flex: 1
		}, 
		{
			header: 'URL',
			dataIndex: 'url',
			flex: 1
		}, 
		{
			header: 'Order Num',
			dataIndex: 'orderNum',
			flex: 1
		}, 
		{
			header: 'Item Id',
			dataIndex: 'itemDTO.itemId',
			flex: 1
		}, 
		{
			header: 'VideoSrc Id',
			dataIndex: 'videoSrcDTO.videoSrcId',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})