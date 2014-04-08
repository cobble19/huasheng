Ext.define('HS.view.role.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.rolelist',
	
	title: '视频列表',
	id: 'role-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'RoleStore',
	dockedItems: [{
        xtype: 'toolbar',
        //height: 60,
        //dock: 'top',
        items: [{
        	xtype: 'textfield',
			name: 'roleEntitySearch.roleName',
			fieldLabel: '角色名称',
			labelAlign: 'right'
        }]
    }, {
        xtype: 'pagingtoolbar',
        store: 'RoleStore',   // same store GridPanel is using
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
			header: '角色唯一标识',
			dataIndex: 'roleId',
			flex: 1
		}, 
		{
			header: '角色名称',
			dataIndex: 'roleName',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})