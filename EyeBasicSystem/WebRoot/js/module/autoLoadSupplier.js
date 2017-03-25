$().ready(function() {

	var url = "selSupplierInfoAll.action";

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

	// 制造商
		$("#supplierName").autocomplete(url, options);
		$("#supplierName").result(
				function(event, data, formatted) {
					if (data) {
						$(this).val(formatted);
						$("#supplierID").val(formatted.replace(/(^.* )|[\\(\\)]/g, ""));
					}
		});

	});