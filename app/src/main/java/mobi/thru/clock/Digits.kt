package mobi.thru.clock

fun getDigits(value: Int): Array<Time> =
    when (value) {
        0 -> arrayOf(
            Time(hour = 6F, minute = 15F),
            Time(hour = 9F, minute = 30F),
            Time(hour = 6F, minute = 0F),
            Time(hour = 0F, minute = 30F),
            Time(hour = 3F, minute = 0F),
            Time(hour = 0F, minute = 45F),
        )
        1 -> arrayOf(
            Time(hour = 7.5F, minute = 37.5F),
            Time(hour = 6F, minute = 30F),
            Time(hour = 7.5F, minute = 37.5F),
            Time(hour = 6F, minute = 0F),
            Time(hour = 7.5F, minute = 37.5F),
            Time(hour = 0F, minute = 0F)
        )
        2 -> arrayOf(
            Time(hour = 3F, minute = 15F),
            Time(hour = 9F, minute = 30F),
            Time(hour = 6F, minute = 15F),
            Time(hour = 0F, minute = 45F),
            Time(hour = 0F, minute = 15F),
            Time(hour = 9F, minute = 45F)
        )
        3 -> arrayOf(
            Time(hour = 3F, minute = 15F),
            Time(hour = 9F, minute = 30F),
            Time(hour = 3F, minute = 15F),
            Time(hour = 9F, minute = 0F),
            Time(hour = 3F, minute = 15F),
            Time(hour = 9F, minute = 0F)
        )
        4 -> arrayOf(
            Time(hour = 6F, minute = 30F),
            Time(hour = 6F, minute = 30F),
            Time(hour = 0F, minute = 15F),
            Time(hour = 6F, minute = 0F),
            Time(hour = 7.5F, minute = 37.5F),
            Time(hour = 0F, minute = 0F)
        )
        5 -> arrayOf(
            Time(hour = 6F, minute = 15F),
            Time(hour = 9F, minute = 45F),
            Time(hour = 0F, minute = 15F),
            Time(hour = 6F, minute = 45F),
            Time(hour = 3F, minute = 15F),
            Time(hour = 0F, minute = 45F)
        )
        6 -> arrayOf(
            Time(hour = 6F, minute = 15F),
            Time(hour = 9F, minute = 45F),
            Time(hour = 6F, minute = 0F),
            Time(hour = 6F, minute = 45F),
            Time(hour = 0F, minute = 15F),
            Time(hour = 0F, minute = 45F)
        )
        7 -> arrayOf(
            Time(hour = 3F, minute = 15F),
            Time(hour = 6F, minute = 45F),
            Time(hour = 7.5F, minute = 37.5F),
            Time(hour = 6F, minute = 0F),
            Time(hour = 7.5F, minute = 37.5F),
            Time(hour = 0F, minute = 0F)
        )
        8 -> arrayOf(
            Time(hour = 6F, minute = 15F),
            Time(hour = 6F, minute = 45F),
            Time(hour = 0F, minute = 15F),
            Time(hour = 0F, minute = 45F),
            Time(hour = 0F, minute = 15F),
            Time(hour = 0F, minute = 45F)
        )
        9 -> arrayOf(
            Time(hour = 6F, minute = 15F),
            Time(hour = 6F, minute = 45F),
            Time(hour = 3F, minute = 0F),
            Time(hour = 6F, minute = 0F),
            Time(hour = 3F, minute = 15F),
            Time(hour = 0F, minute = 45F)
        )
        else -> arrayOf(
            Time(hour = 6F, minute = 15F),
            Time(hour = 9F, minute = 30F),
            Time(hour = 6F, minute = 0F),
            Time(hour = 0F, minute = 30F),
            Time(hour = 3F, minute = 0F),
            Time(hour = 0F, minute = 45F),
        )
    }
