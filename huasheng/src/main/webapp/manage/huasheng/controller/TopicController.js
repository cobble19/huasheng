Ext.define('HS.controller.TopicController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['TopicStore'],
	models: ['TopicModel'],
	views: ['topic.List', 'topic.Edit'],
	refs: [{
	    ref: 'topicList',
	    selector: 'viewport topiclist'
	}],
	init: function() {
		console.log("TopicController init...");
		this.control({
			'viewport topiclist': {
				itemdblclick: this.openDialog4Update
			},
			'topicedit button[action=save]': {
				click: this.updateTopic
			},
			'viewport topiclist button[action=search]': {
				click: this.searchTopic
			},
			'viewport topiclist button[action=add]': {
				click: this.openDialog4Add
			},
			'topicedit button[action=add]': {
				click: this.addTopic
			},
			'viewport topiclist button[action=update]': {
				click: this.openDialog4Update
			},
			'topicedit button[action=save]': {
				click: this.updateTopic
			},
			'viewport topiclist button[action=delete]': {
				click: this.openDialog4Delete
			}
			/*'viewport > panel' : {
				render: this.onPanelRendered
			}*/
		});
	},
	searchTopic: function(button) {
		var nameEle = Ext.ComponentQuery.query('panel textfield[name=topicDTOSearch.name]')[0];
		name = nameEle.getValue();
		var store = this.getTopicStoreStore();
		store.load({
			params: {
	            'topicDTOSearch.name': name
	        }
		});
		console.log('searchTopic...' + name);
	},
	openDialog4Add: function(button) {
		console.log('add dialog...');
		var view = Ext.widget('topicedit');
		var btns = Ext.query('a[id=btnSave]');
		Ext.Array.each(btns, function(btn) {
			Ext.get(btn).hide();
		})
		var inputTopicId = Ext.query('input[name=topicId]');
		Ext.get(inputTopicId).hide();
	},
	addTopic: function(button) {
		var win = button.up('window'),
			form = win.down('form'), 
			f = form.getForm();
		var me = this;
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/topic!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				var topicDTO = action.result.topicDTO;
				var record = Ext.create('HS.model.TopicModel', {
					topicId: topicDTO.topicId,
					name: topicDTO.name
				});
				var index = 0;
				var records = Ext.getStore('TopicStore').insert(index, record);
				// change color
				me.getTopicList().getView().addRowCls(record, 'red');
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
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('警告', '请选择一条记录');
			return;
		} else {
			//Ext.MessageBox.alert('Info', records[0].data.name);
			var view = Ext.widget('topicedit');
			var btns = Ext.query('a[id=btnAdd]');
			Ext.Array.each(btns, function(btn) {
				Ext.get(btn).hide();
			})
			view.down('form').loadRecord(records[0]);
		}
	},
	updateTopic: function(button) {
		var win = button.up('window'),
			form = win.down('form'), 
			f = form.getForm();
		var me = this;
		record = form.getRecord();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/topic!update',
			method: 'POST',
			success: function(form, action) {
				record = form.getRecord();
				record.set(form.getValues());
				record.commit();
				win.close();
				// change color
				me.getTopicList().getView().addRowCls(record, 'red');
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
			records = selModel.getSelection();
		var deleteTopic = this.deleteTopic;
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('警告', '请选择一条记录');
			return;
		} else {
			Ext.MessageBox.show({
				title: '确认提示',
				icon: Ext.MessageBox.WARNING,
				msg: '确认删除数据？',
				buttons: Ext.Msg.OKCANCEL,
				/*multiline: true,*/
				fn : function(buttonId, text, opt) {
					if (buttonId == 'ok') {
						deleteTopic(records);
					}// end if
				}
			});
		}
		
	},
	deleteTopic: function(records) {
		var ids = [];
		Ext.Array.each(records, function(record) {
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
			success: function(response, options) {
				Ext.Array.each(records, function(record) {
					Ext.getStore('TopicStore').remove(record);
				}
				);
				/*Ext.getStore('TopicStore').sync();*/
				Ext.MessageBox.alert('信息', '删除成功!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('警告', '删除失败!');
			}
		});
	},
	onPanelRendered : function() {
		console.log('The panel was rendered.')
	}
});