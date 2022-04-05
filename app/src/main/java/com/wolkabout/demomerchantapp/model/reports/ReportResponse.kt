package com.wolkabout.demomerchantapp.model.reports

data class ReportResponse(
    val groupNames: List<String>,
    val groupTotal: List<Double>,
    val groupsData: List<GroupsData>,
    val total: Double,
    val unit: String
)