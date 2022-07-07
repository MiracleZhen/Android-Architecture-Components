package com.ling.dagger2.part03

import dagger.Subcomponent

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : SubSourceComponent
 */
@Subcomponent
interface SubSourceComponent {

    fun inject(subRepository: SubRepository)
}
