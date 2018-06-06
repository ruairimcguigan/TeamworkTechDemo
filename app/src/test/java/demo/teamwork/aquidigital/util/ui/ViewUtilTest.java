package demo.teamwork.aquidigital.util.ui;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import demo.teamwork.aquidigital.common.BaseTests;
import demo.teamwork.aquidigital.createproject.models.TagItem;
import demo.teamwork.aquidigital.viewprojects.model.ProjectItem;
import demo.teamwork.aquidigital.util.TestData;

import static junit.framework.Assert.assertEquals;

public class ViewUtilTest extends BaseTests{

    private ViewUtil viewUtil;

    @Before
    public void setUp() {
        viewUtil = new ViewUtil();
    }

    @Test
    public void getCompanyNames() {

        // given
        String expectedCompanyNames = "[Great company, Great company, Great company]";
        List<ProjectItem> projects = TestData.getProjectResponse().getProjects();

        // when
        viewUtil.getCompanyNames(projects);

        // then
        assertEquals(expectedCompanyNames, viewUtil.getCompanyNames(projects).toString());
    }

    @Test
    public void getTagNames() {

        // given
        String expectedTags = "[tag 1, tag 2, tag 3]";
        List<TagItem> tags = TestData.getTagResponse().getTags();

        // when
        viewUtil.getTagNames(tags);

        // then
        assertEquals(expectedTags, viewUtil.getTagNames(tags).toString());
    }

    @Test
    public void getCategories() {

        // given
        String expectedCategories = "[100, 100, 100]";
        List<ProjectItem> categories = TestData.getProjectResponse().getProjects();

        // when
        viewUtil.getCategories(categories);

        // then
        assertEquals(expectedCategories, viewUtil.getCategories(categories).toString());
    }

    @Test
    public void formatDateForDisplay() {

        // given
        int year= 2018;
        int month = 7;
        int dayOfMonth = 4;
        String expected = "4/7/2018";

        // when
        viewUtil.formatDateForDisplay(dayOfMonth, month, year);

        // then
        assertEquals(expected, viewUtil.formatDateForDisplay(dayOfMonth, month, year));
    }

    @Test
    public void formatForRequest() {

        // given
        int year= 2018;
        int month = 7;
        int dayOfMonth = 4;
        String expected = "20180704";

        // when
        viewUtil.formatForRequest(year, month, dayOfMonth);

        // then
        assertEquals(expected, viewUtil.formatForRequest(year, month, dayOfMonth));

    }

    @Test
    public void shouldPrefixValueWithZeroIfDateNotDoubleDigit() {
        String expected = "04";
        viewUtil.prefixWithZeroFormat(4);
        assertEquals(expected, viewUtil.prefixWithZeroFormat(4));

    }
}