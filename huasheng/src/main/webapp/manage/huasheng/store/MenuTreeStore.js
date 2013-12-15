Ext.define('HS.store.MenuTreeStore', {
	extend: 'Ext.data.TreeStore',
	/*model: 'HS.model.MenuTreeModel',*/
	autoLoad: true,
	root: {
		expanded: true
	},
	proxy: {
		type: 'ajax',
		url: Ext.get('contextPath').dom.value + '/data/menuTree.json'
	}
})