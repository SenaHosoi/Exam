package jp.ac.ohara.senatyan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.senatyan.model.GakuseiHyou;
import jp.ac.ohara.senatyan.repository.GakuseiRepository;

 

@Service
@Transactional
public class  GakuseiService{

    @Autowired
    private GakuseiRepository repository;

    /**
     * 学生一覧の取得
     * @return List<Gakusei>
     */
    public List<GakuseiHyou> getGakuseiList() {
        List<GakuseiHyou> entityList = this.repository.findAll();
        return entityList;
    }

    /**
     * 詳細データの取得
     * @param @NonNull Long index

     */
    public GakuseiHyou get(@NonNull Long index) {
        GakuseiHyou gakusei = this.repository.findById(index).orElse(new GakuseiHyou());
        return gakusei;
    }

    public void save(@NonNull GakuseiHyou gakusei) {
        this.repository.save(gakusei);
    }


  //学生データの削除・編集
    public void delete(@NonNull Long index) {
    		this.repository.deleteById(index);
    	}
    	
        public List<GakuseiHyou> getStudentList1() {
            return repository.findAll();
        }

        public GakuseiHyou getStudentById(Long id) {
            return repository.findById(id).orElse(null);
        }

        public void saveOrUpdateStudent(GakuseiHyou student) {
            repository.save(student);
        }

        public void deleteStudent(Long id) {
            repository.deleteById(id);
        }



}