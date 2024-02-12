package com.example.retrofit


import com.squareup.moshi.Json

data class KorHosResponse(
    @field:Json(name = "CHSEMGNCYCENTER")
    val cHSEMGNCYCENTER: List<CHSEMGNCYCENTER?>?
)
data class CHSEMGNCYCENTER(
    @field:Json(name = "head")
    val head: List<Head?>?,
    @field:Json(name = "row")
    val row: List<Row?>?
)
data class Head(
    @field:Json(name = "api_version")
    val apiVersion: String?,
    @field:Json(name = "list_total_count")
    val listTotalCount: Int?,
    @field:Json(name = "RESULT")
    val rESULT: RESULT?
)
data class RESULT(
    @field:Json(name = "CODE")
    val cODE: String?,
    @field:Json(name = "MESSAGE")
    val mESSAGE: String?
)
data class Row(
    @field:Json(name = "DISTRCT_DIV_NM")
    val dISTRCTDIVNM: String?, // "DISTRCT_DIV_NM" 이라는 애가 있으면 읽어서 dISTRCTDIVNM 변수에 저장
    @field:Json(name = "EMGNCY_CENTER_TELNO")
    val eMGNCYCENTERTELNO: String?,
    @field:Json(name = "MEDCARE_INST_NM")
    val mEDCAREINSTNM: String?,
    @field:Json(name = "REFINE_LOTNO_ADDR")
    val rEFINELOTNOADDR: String?,
    @field:Json(name = "REFINE_ROADNM_ADDR")
    val rEFINEROADNMADDR: String?,
    @field:Json(name = "REFINE_WGS84_LAT")
    val rEFINEWGS84LAT: String?,
    @field:Json(name = "REFINE_WGS84_LOGT")
    val rEFINEWGS84LOGT: String?,
    @field:Json(name = "REFINE_ZIP_CD")
    val rEFINEZIPCD: String?,
    @field:Json(name = "REPRSNT_TELNO")
    val rEPRSNTTELNO: String?,
    @field:Json(name = "SIGUN_NM")
    val sIGUNNM: String?
)