Ext.define('HS.view.privilege.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.privilegelist',
	
	title: '权限列表',
	id: 'privilege-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI'
	},
	store: 'PrivilegeStore',
	dockedItems: [{
        xtype: 'toolbar',
        //height: 60,
        //dock: 'top',
        items: [{
        	xtype: 'textfield',
			name: 'privilegeEntitySearch.resource',
			fieldLabel: '权限URL',
			labelAlign: 'right'
        }]
    }, {
        xtype: 'pagingtoolbar',
        store: 'PrivilegeStore',   // same store GridPanel is using
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
			header: '权限唯一标识',
			dataIndex: 'privilegeId',
			flex: 1
		}, 
		{
			header: '权限名称',
			dataIndex: 'name',
			flex: 1
		}, 
		{
			header: '权限URL',
			dataIndex: 'resource',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})