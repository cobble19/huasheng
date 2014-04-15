Ext.application({
	requires: ['Ext.container.Viewport'],
	name: "HS",
	appFolder: "huasheng",
	
	controllers: [
		'MenuTreeController',
		/*'ContentController',*/
		'TopicController',
		'CategoryController',
		'ItemController',
		'VideoSrcController',
		'VideoController',
		'FragmentController',
		'RoleController',
		'UserController',
		'PrivilegeController'
	],
	stores: ['TopicStore'],
	models: ['TopicModel'],
	views: ['content.Panel', 'checkbox.PrivilegeCheckboxGroup'],
	launch: function() {
		console.log('Ext Ajax');

		Ext.Ajax.on('beforerequest', this.testFunB, this);
		Ext.Ajax.on('requestcomplete', this.testFunC, this);
		Ext.Ajax.on('requestexception', this.testFunE, this);
		
		Ext.create('Ext.container.Viewport', {
			layout: "border",
			title: 'manage platform view',
			items: [
				{
					xtype: 'component',
					region: 'north',
					id: 'header',
					height: 40,
					html: '<h4>花生管理台 欢迎【' + Ext.get('username').dom.value + 
							'】 <a href="' + Ext.get('contextPath').dom.value + '/j_spring_security_logout">退出</a></h4>'
				}, {
					xtype: 'menutreelist',
					region: 'west',
					margins: '0 0 0 2',
					width: 150
				}, {
					xtype: 'contentpanel',
					margins: '0 2 0 2',
					region: 'center'
				}, {
					xtype: 'component',
					region: 'east',
					html: ''
				}, {
					xtype: 'component',
					region: 'south',
					margins: '5',
					html: 'copyright &copy; Email: publiclzhc@sina.com'
				}
			]
		});
	},
	testFunB : function(conn, opts) {
		console.log('testFunB... ajax...');
	},
	testFunC : function(conn, response, opts) {
		console.log('testFunC... ajax...');
		var ajaxText = response.responseText;
		ajaxText = Ext.decode(ajaxText);
		if (ajaxText.status == false) {
			console.log('ajaxText.status=' + ajaxText.status);
			alert("权限不足或过期。请重新登录。");
			window.location.href = Ext.get('contextPath').dom.value + "/manage/login.jsp";  
		}
	},
	testFunE : function(conn, response, opts) {
		console.log('testFunE... ajax...');
	}
	
})