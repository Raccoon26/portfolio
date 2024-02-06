package com.raccoon.portfolio.admin.context.dashboard.data

import org.springframework.boot.ansi.AnsiBackground

class VisitorsDTO(
    var name: String,
    var count: Long,
    var color: String,
    var background: String
) {
}