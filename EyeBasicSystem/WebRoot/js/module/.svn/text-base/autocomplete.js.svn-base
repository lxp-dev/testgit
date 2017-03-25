$().ready(function() {

	var url = "selPersonInfoAll.action";

	var options = {
		width : 260,
		selectFirst : false,
		autoFill : false,
		dataType : 'json',
		selectFirst : true,
		parse : function(data) {
			var json = data.personAjax;

			for (i = 0; i < json.length; i++) {
				json[i] = {
					data : [ json[i] ],
					resulet : json[i],
					value : json[i]
				};
			}
			return json;
		}
	};

	// 创建人
		$("#createPersonName1").autocomplete(url, options);

		$("#createPersonName1").result(
				function(event, data, formatted) {
					if (data) {
						$(this).val(formatted);
						$("#createPersonID1").val(
						formatted.replace(/(^.* )|[\\(\\)]/g, ""));
					}
				});

		// 审核人
		$("#auditPersonName1").autocomplete(url, options);

		$("#auditPersonName1").result(
				function(event, data, formatted) {
					if (data) {
						$(this).val(formatted);
						$("#auditPersonID1").val(
								formatted.replace(/(^.* )|[\\(\\)]/g, ""));
					}
				});

		// 财务审核人
		/*$("#financeAuditPersonName").autocomplete(url, options);

		$("#financeAuditPersonName").result(
				function(event, data, formatted) {
					if (data) {
						$(this).val(formatted);
						$("#financeAuditPersonID").val(
								formatted.replace(/(^.* )|[\\(\\)]/g, ""));
					}
				}); */
		// 收货人
		$("#consigneePersonName1").autocomplete(url, options);

		$("#consigneePersonName1").result(
				function(event, data, formatted) {
					if (data) {
						$(this).val(formatted);
						$("#consigneePersonID1").val(
								formatted.replace(/(^.* )|[\\(\\)]/g, ""));
					}
				}); 

	});