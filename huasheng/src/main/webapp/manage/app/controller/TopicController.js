Ext.define('MNG.controller.TopicController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['TopicStore'],
	models: ['TopicModel'],
	views: ['topic.List', 'topic.Edit'],
	init: function() {
		console.log("TopicController init...");
		this.control({
			'viewport > topiclist': {
				itemdblclick: this.editTopic
			},
			'topicedit button[action=save]': {
				click: this.updateTopic
			},
			'viewport > topiclist button[text=add]': {
				click: this.openDialog4Add
			},
			'topicedit button[action=add]': {
				click: this.addTopic
			},
			'viewport > topiclist button[text=update]': {
				click: this.openDialog4Update
			},
			'topicedit button[action=save]': {
				click: this.updateTopic
			},
			'viewport > topiclist button[text=delete]': {
				click: this.openDialog4Delete
			}
			/*'viewport > panel' : {
				render: this.onPanelRendered
			}*/
		});
	},
	openDialog4Add: function(button) {
		console.log('add dialog...');
		/*var grid = button.up('topiclist'),
			selModel = grid.getSelectionModel( ),
			data = selModel.getSelection();
		if (data == null || data.length == 0) {
			Ext.MessageBox.alert('Info', 'please select ONE row');
		} else {
			Ext.MessageBox.alert('Info', data);
		}*/
		var view = Ext.widget('topicedit');
	},
	addTopic: function(button) {
		var win = button.up('window'),
			form = win.down('form'), 
			f = form.getForm();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/topic!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				Ext.MessageBox.alert(action.response.statusText);
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
		
		
	},
	openDialog4Update: function(button) {
		console.log('update dialog...');
		var grid = button.up('topiclist'),
			selModel = grid.getSelectionModel( ),
			data = selModel.getSelection();
		if (data == null || data.length == 0) {
			Ext.MessageBox.alert('Info', 'please select ONE row');
			return;
		} else {
			Ext.MessageBox.alert('Info', data[0].data.name);
		}
		var view = Ext.widget('topicedit');
		view.down('form').loadRecord(data[0]);
	},
	updateTopic: function(button) {
		var win = button.up('window'),
			form = win.down('form'), 
			f = form.getForm();
		record = form.getRecord();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/topic!update',
			method: 'POST',
			success: function(form, action) {
				record = form.getRecord();
				record.set(form.getValues());
				record.commit();
				win.close();
				//Ext.getStore('TopicStore').sync();
				Ext.MessageBox.alert(action.response.statusText);
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
	},
	openDialog4Delete: function(button) {
		console.log('delete dialog...');
		var grid = button.up('topiclist'),
			selModel = grid.getSelectionModel( ),
			data = selModel.getSelection();
		if (data == null || data.length == 0) {
			Ext.MessageBox.alert('Info', 'please select ONE row');
			return;
		} else {
			Ext.MessageBox.show({
				title: 'Confirm',
				msg: '确认删除数据？',
				buttons: Ext.Msg.OKCANCEL,
				/*multiline: true,*/
				fn : function(button) {
					console.log('button');
				},
				icon: Ext.MessageBox.WARNING
			});
		}
		
		var ids = [];
		/*for (var i = 0; i < data.length; i++) {
			ids.push(data[i].data.topicId);
		}*/
		Ext.Array.each(data, function(record) {
			ids.push(record.get('topicId'));
		});
		params = {
			'ids': ids.join(',')
		};
		Ext.Ajax.request({
			url: Ext.get('contextPath').dom.value + '/json/topic!delete',
			method: 'POST',
			params: params,
			/*jsonData : params,*/
			/*headers: {
				'Content-Type': 'application/json; charset=UTF-8'
			},*/
			success: function(response, options) {
				Ext.Array.each(data, function(record) {
					Ext.getStore('TopicStore').remove(record);
				}
				);
				Ext.getStore('TopicStore').sync();
				Ext.MessageBox.alert(response.statusText);
			},
			failure: function(response, options) {
				Ext.MessageBox.alert(response.statusText);
			}
		});
		
	},
	/*editTopic: function(grid, record) {
		console.log('Double clicked on ' + record.get('name'));
		var view = Ext.widget('topicedit');
		view.down('form').loadRecord(record);
	},*/
	/*updateTopic: function(button) {
		console.log('Clicked the save button.');
		var win = button.up('window'),
			form = win.down('form'),
			record = form.getRecord(),
			values = form.getValues();
		record.set(values);
		win.close();
		// synchronize the store
		this.getStore('TopicStore').sync();
	},*/
	onPanelRendered : function() {
		console.log('The panel was rendered.')
	}
});