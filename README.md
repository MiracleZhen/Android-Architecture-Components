Android Architecture Components - 安卓架构组件
AAC即Android Architecture Components，谷歌在Google I/O 2017上发布的帮助开发者构建易于维护测试/健壮的架构设计方案。
它的核心应该是基于观察者模式的，其主要的两大内容就是： 
1. 生命周期相关的 Lifecycle-aware Components（生命周期感知组件）
2. 数据库解决方案 Room 
组件功能：处理数据持久化和管理生命周期（生命周期感知组件执行操作以响应另一个组件（例如活动和片段）的生命周期状态的更改），能够有效的避免内存泄漏等问题。
