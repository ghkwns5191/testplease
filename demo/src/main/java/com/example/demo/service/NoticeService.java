package com.example.demo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DataNotFoundException;
import com.example.demo.model.Notice;
import com.example.demo.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeService {
	
	
	@Autowired
	private final NoticeRepository noticeRepository;
	
	
	public Notice register(String ntitle, String ncontent) {
		Notice notice = new Notice();
		notice.setNtitle(ntitle);
		notice.setNcontent(ncontent);
		notice.setNrdate(LocalDate.now());
		return this.noticeRepository.save(notice);
	}
	
//	public Page<Notice> getList(int page, String kw) {
//		Integer nid = null;
//		List<Sort.Order> sorts = new ArrayList();
//		sorts.add(Sort.Order.desc("nid"));
//		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
//		Specification<Notice> spec = search(kw); 
//		return this.noticeRepository.findAll(spec, pageable);
//	}
	
//	private Specification<Notice> search(String kw) {
//        return new Specification<>() {
//            private static final long serialVersionUID = 1L;
//            @Override
//            public Predicate toPredicate(Root<Notice> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                query.distinct(true);  // 중복을 제거 
//                Join<Notice, Member> u1 = q.join("author", JoinType.LEFT);
//                return cb.or(cb.like(q.get("subject"), "%" + kw + "%"), // 제목 
//                        cb.like(q.get("content"), "%" + kw + "%"),      // 내용 
//                        cb.like(u1.get("username"), "%" + kw + "%"));  // 질문 작성자 
//                       
//            }
//			
//        };
//    
//			
//			
//	}

	public void modify(Notice notice, String ntitle, String ncontent, String nfile) {
		notice.setNtitle(ntitle);
		notice.setNcontent(ncontent);
		notice.setNfile(nfile);
		this.noticeRepository.save(notice);
	}
	
	public void delete(Notice notice) {
		this.noticeRepository.delete(notice);
	}
	
	public Notice getNotice(Integer nid) {
		Optional<Notice> notice = this.noticeRepository.findById(nid);
		if(notice.isPresent()) {
			return notice.get();
		} else {
			throw new DataNotFoundException("notice not found");
		}
	}
}

	
