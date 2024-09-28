package com.embarkx.jobapp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void addCompany(Company company);

    Company updateCompany(Company updatedCompany, Long id);

    Company getCompanyById(Long id);

    Boolean deleteCompanyById(Long id);

}
