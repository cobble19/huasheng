Ext.define('HS.view.videoSrc.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.videosrclist',
	
	title: '视频源列表',
	id: 'videoSrc-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'VideoSrcStore',
	dockedItems: [{
        xtype: 'toolbar',
        //height: 60,
        //dock: 'top',
        items: [{
        	xtype: 'textfield',
			name: 'videoSrcDTOSearch.name',
			fieldLabel: '主题名称',
			labelAlign: 'right'
        }]
    }, {
        xtype: 'pagingtoolbar',
        store: 'VideoSrcStore',   // same store GridPanel is using
        dock: 'bottom',
        displayInfo: true
    }],
	tbar: [
	{
		xtype: 'button',
		text: '查询',
		action: 'search'
	},
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
			header: '视频源唯一标识',
			dataIndex: 'videoSrcId',
			flex: 1
		}, 
		{
			header: '视频源名称',
			dataIndex: 'name',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})