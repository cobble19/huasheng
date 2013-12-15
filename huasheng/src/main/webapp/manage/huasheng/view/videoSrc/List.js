Ext.define('HS.view.videoSrc.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.videosrclist',
	
	title: 'VideoSrc List',
	id: 'videoSrc-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'VideoSrcStore',
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
			header: 'VideoSrc Id',
			dataIndex: 'videoSrcId',
			flex: 1
		}, 
		{
			header: 'Name',
			dataIndex: 'name',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})