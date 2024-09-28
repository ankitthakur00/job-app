package com.embarkx.jobapp.company.impl;
import com.embarkx.jobapp.company.Company;
import com.embarkx.jobapp.company.CompanyRepository;
import com.embarkx.jobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company company) {
       companyRepository.save(company);
    }


    @Override
    public Company updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {
            Company cmp = companyOptional.get();
            if (updatedCompany.getDescription() != null) cmp.setDescription(updatedCompany.getDescription());
            if (updatedCompany.getName() != null) cmp.setName(updatedCompany.getName());
            cmp.setJobs(updatedCompany.getJobs());
            companyRepository.save(cmp);
            return cmp;
        }
        return null;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        if(company==null){
            return false;
        }
        companyRepository.deleteById(id);
        return true;
    }

}
