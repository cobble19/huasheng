Ext.define('HS.view.fragment.List', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.fragmentlist',
	
	title: '处理URL',
	id: 'fragment-list',
	selType: 'checkboxmodel',
	selModel: {
		model: 'MULTI',
		singleSelect:false
	},
	store: 'FragmentStore',
	dockedItems: [{
        xtype: 'toolbar',
        //height: 60,
        //dock: 'top',
        items: [{
        	xtype: 'textfield',
			name: 'fragmentDTOSearch.url',
			fieldLabel: 'URL',
			labelAlign: 'right',
			value: 'http://v.qq.com/cover/8/8fpoa2lh15bycyu.html'
        }]
    }],
	tbar: [
	{
		xtype: 'button',
		text: '查询',
		action: 'search'
	}
	],
	initComponent: function() {
		this.columns = [
		{xtype: 'rownumberer'},
		{
			header: '片段',
			dataIndex: 'content',
			flex: 1
		}
		];
		this.callParent(arguments);
	}
})