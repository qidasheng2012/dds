package com.it.service.impl;

import com.it.entity.Product;
import com.it.mapper.ProductMapper;
import com.it.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
