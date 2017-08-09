package com.rkovtiuk.blog_ms.dashboard.service.impl;

import com.rkovtiuk.blog_ms.core.domain.model.BlogDTO;
import com.rkovtiuk.blog_ms.dashboard.domain.mappers.BlogMapper;
import com.rkovtiuk.blog_ms.dashboard.repository.BlogRepository;
import com.rkovtiuk.blog_ms.dashboard.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private final int PER_PAGE = 20;
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }

    @Override
    public List<BlogDTO> dashboard(int page) {
        PageRequest pageRequest = new PageRequest(page, PER_PAGE, null,null);
        return blogMapper.map(blogRepository.findAllOrderByCreatedDate(pageRequest));
    }
}
