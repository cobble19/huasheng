Ext.define('HS.view.checkbox.PrivilegeCheckboxGroup', {
	extend: 'Ext.form.CheckboxGroup',
	alias: 'widget.privilegecheckboxgroup',
	fieldLabel: '权限',
	id: 'privilegecheckboxgroup',
	name: 'privilegecheckboxgroup',
	width: 300,
	/*height: 100,*/
	columns: 2,
	items: [
	],
	listeners: {
		beforerender: function(cmp, eOpts) {
			//console.log('cmp:' + cmp);
			Ext.getStore('PrivilegeStore').load({
			    scope: this,
			    params: {
			    	limit: 1000
			    },
			    callback: function(records, operation, success) {
			    	Ext.each(records, function(record) {
			    		var checked = false;
			    		var form = cmp.up('form'),
						//f = form.getForm(),
						roleRecord = form.getRecord();
			    		if (!!roleRecord) {
				    		roleId = roleRecord.data.roleId;
				    		console.log('roleid:' + roleId);
				    		if (record.data.roleEntities != null) {
				    			Ext.each(record.data.roleEntities, function(roleEntity) {
				    				if (roleId == roleEntity.roleId) {
				    					checked = true;
				    				}
				    			});
				    		}
			    		}
			    		cmp.add({
			    			boxLabel: record.data.name,
			    			name: 'privilegeIds',
			    			value: record.data.privilegeId,
			    			inputValue: record.data.privilegeId,
			    			checked: checked
			    		});
			    	});
			    }
			});
		}
	}
})