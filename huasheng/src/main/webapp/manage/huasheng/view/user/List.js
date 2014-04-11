Ext.define('HS.view.user.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.userlist',
	
	title: '用户列表',
	id: 'user-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'UserStore',
	dockedItems: [{
        xtype: 'toolbar',
        //height: 60,
        //dock: 'top',
        items: [{
        	xtype: 'textfield',
			name: 'userEntitySearch.userName',
			fieldLabel: '用户名称',
			labelAlign: 'right'
        }]
    }, {
        xtype: 'pagingtoolbar',
        store: 'UserStore',   // same store GridPanel is using
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
	},
	{
		xtype: 'button',
		text: '修改密码',
		action: 'changePwd'
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
			header: '用户唯一标识',
			dataIndex: 'userId',
			flex: 1
		}, 
		{
			header: '用户名称',
			dataIndex: 'userName',
			flex: 1
		}, 
		{
			header: '用户密码',
			dataIndex: 'password',
			hidden: true,
			flex: 1
		}, 
		{
			header: '用户有效性',
			dataIndex: 'enabled',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})