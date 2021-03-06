Ext.define('HS.view.item.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.itemedit',
	
	title: '影视编辑',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'itemId',
						fieldLabel: '影视唯一标识'
					}, 
					{
						xtype: 'textfield',
						name: 'name',
						fieldLabel: '影视名称',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
					}, 
					{
						xtype: 'textfield',
						name: 'hits',
						fieldLabel: '点击率'
					}, 
					{
						xtype: 'textfield',
						name: 'areaName',
						fieldLabel: '地区'
					}, 
					{
						xtype: 'datefield',
						name: 'showDate',
						fieldLabel: '上映时间',
						//format: 'Y-m-d',
						renderer : Ext.util.Format.dateRenderer('Y-m-d')
					}, 
					{
						xtype: 'textfield',
						name: 'year',
						fieldLabel: '上映年份'
					}, 
					{
						xtype: 'textfield',
						name: 'score',
						fieldLabel: '评分'
					}, 
					{
						xtype: 'textareafield',
						name: 'description',
						fieldLabel: '简介'
					}, 
					{
						xtype: 'textfield',
						name: 'actorName',
						fieldLabel: '演员'
					}, 
					{
						xtype: 'textfield',
						name: 'itemType',
						fieldLabel: '类型'
					}, 
					{
						xtype: 'textfield',
						name: 'director',
						fieldLabel: '导演'
					}, 
					{
						xtype: 'hiddenfield',
						name: 'imgUrl',
						fieldLabel: '图片URL'
					}, 
					{
						xtype: 'filefield',
						id: 'upload',
						name: 'upload',
						fieldLabel: '图片',
						emptyText: '请选择图片...',
						msgTarget: 'side',
				        allowBlank: true,
				        anchor: '100%',
				        buttonText: '浏览...'
					}/*, 
					{
						xtype: 'textfield',
						name: 'categoryDTO.categoryId',
						fieldLabel: 'Category Id'
					}*/,
					{
						xtype: 'categorycombobox',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
					}
				]
			}
		];
		this.buttons = [
		{
			text: '添加',
			action: 'add',
			id: 'btnAdd'
		},
		{
			text: '修改',
			action: 'update',
			id: 'btnUpdate'
		}, 
		{
			text: '取消',
			scope: this,
			handler: this.close
		}
		];
		this.callParent(arguments);
	}
})