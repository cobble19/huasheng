Ext.define('HS.store.TopicStore', {
	extend: 'Ext.data.Store',
	/*fields: ['topicId', 'name'],*/
	model: 'HS.model.TopicModel',
	/*data: [
		{topicId: 1, name: 'TopicName1'},
		{topicId: 2, name: 'topicName2'}
	]*/
	autoLoad: false,
	proxy: {
		type: 'ajax',
		/*url: Ext.get('contextPath').dom.value + '/json/topic!execute',*/
		actionMethods: {
			read: 'POST'
		},
		api: {
			read: encodeURI(encodeURI(Ext.get('contextPath').dom.value + '/json/topic!execute')),
			update: Ext.get('contextPath').dom.value + '/json/topic!update',
			create: '',
			destroy: ''
		},
		reader: {
			type: 'json',
			root: 'topicDTOList',
			successProperty: 'success'
		},
		writer: {
            encode: true,
            root: 'updatedStr'
        }
	},
	listeners: {
		update: function(store, record, operation, modifiedFieldNames, eOpts) {
			console.log("record been updated." + 'operation:' + operation);
			/*var tr = Ext.query('tr[data-recordindex=' + record.index + ']');
			Ext.get(tr).addCls('red')*/
            /*var el = Ext.get(tr).select('td');
            el.addCls('red');  */
		},
		add: function( store, records, index, eOpts ) {
			console.log('record been added. index=' + index);
			/*var tr = Ext.query('tr[data-recordindex=' + index + ']');
			Ext.get(tr).addCls('red')*/
            /*el = Ext.get(tr).select('td');
            el.addCls('red');   */                     
		}
	}
})