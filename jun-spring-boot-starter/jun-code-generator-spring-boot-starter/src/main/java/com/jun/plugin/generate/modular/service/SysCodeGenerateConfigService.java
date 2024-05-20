/*
Copyright [2020] [https://www.xiaonuo.vip]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改Snowy源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/xiaonuobase/snowy-layui
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/xiaonuobase/snowy-layui
6.若您的项目无法满足以上几点，可申请商业授权，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.jun.plugin.generate.modular.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jun.plugin.generate.core.ref.PageResult;
import com.jun.plugin.generate.modular.entity.CodeGenerate;
import com.jun.plugin.generate.modular.entity.SysCodeGenerateConfig;
import com.jun.plugin.generate.modular.param.SysCodeGenerateConfigParam;
import com.jun.plugin.generate.modular.result.InforMationColumnsResult;

import java.util.List;

/**
 * 代码生成详细配置service接口
 *
 * @author yubaoshan
 * @date 2021-02-06 20:19:49
 */
public interface SysCodeGenerateConfigService extends IService<SysCodeGenerateConfig> {

    /**
     * 代码生成详细配置列表
     *
     * @author yubaoshan
     * @date 2021-02-06 20:19:49
     */
    PageResult<SysCodeGenerateConfig> page(SysCodeGenerateConfigParam sysCodeGenerateConfigParam);

    /**
     * 代码生成详细配置列表
     *
     * @author yubaoshan
     * @date 2021-02-06 20:19:49
     */
    List<SysCodeGenerateConfig> list(SysCodeGenerateConfigParam sysCodeGenerateConfigParam);

    /**
     * 添加代码生成详细配置
     *
     * @author yubaoshan
     * @date 2021-02-06 20:19:49
     */
    void add(SysCodeGenerateConfigParam sysCodeGenerateConfigParam);

    /**
     * 添加代码生成详细配置列表
     *
     * @author yubaoshan
     * @date 2021-02-06 20:19:49
     */
    void addList(List<InforMationColumnsResult> inforMationColumnsResultList, CodeGenerate codeGenerate);

    /**
     * 删除代码生成详细配置
     *
     * @author yubaoshan
     * @date 2021-02-06 20:19:49
     */
    void delete(SysCodeGenerateConfigParam sysCodeGenerateConfigParam);

    /**
     * 编辑代码生成详细配置
     *
     * @author yubaoshan
     * @date 2021-02-06 20:19:49
     */
    void edit(List<SysCodeGenerateConfigParam> sysCodeGenerateConfigParamList);

    /**
     * 查看代码生成详细配置
     *
     * @author yubaoshan
     * @date 2021-02-06 20:19:49
     */
     SysCodeGenerateConfig detail(SysCodeGenerateConfigParam sysCodeGenerateConfigParam);
}
