// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route_guide.proto

package com.htzhu.protobuf.routeguice;

public final class RouteGuideProto {

	private RouteGuideProto() {
	}

	public static void registerAllExtensions(
			com.google.protobuf.ExtensionRegistryLite registry) {
	}

	public static void registerAllExtensions(
			com.google.protobuf.ExtensionRegistry registry) {
		registerAllExtensions(
				(com.google.protobuf.ExtensionRegistryLite) registry);
	}

	static final com.google.protobuf.Descriptors.Descriptor
			internal_static_com_htzhu_protobuf_routeguice_Point_descriptor;
	static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_com_htzhu_protobuf_routeguice_Point_fieldAccessorTable;
	static final com.google.protobuf.Descriptors.Descriptor
			internal_static_com_htzhu_protobuf_routeguice_Rectangle_descriptor;
	static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_com_htzhu_protobuf_routeguice_Rectangle_fieldAccessorTable;
	static final com.google.protobuf.Descriptors.Descriptor
			internal_static_com_htzhu_protobuf_routeguice_Feature_descriptor;
	static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_com_htzhu_protobuf_routeguice_Feature_fieldAccessorTable;
	static final com.google.protobuf.Descriptors.Descriptor
			internal_static_com_htzhu_protobuf_routeguice_FeatureDatabase_descriptor;
	static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_com_htzhu_protobuf_routeguice_FeatureDatabase_fieldAccessorTable;
	static final com.google.protobuf.Descriptors.Descriptor
			internal_static_com_htzhu_protobuf_routeguice_RouteNote_descriptor;
	static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_com_htzhu_protobuf_routeguice_RouteNote_fieldAccessorTable;
	static final com.google.protobuf.Descriptors.Descriptor
			internal_static_com_htzhu_protobuf_routeguice_RouteSummary_descriptor;
	static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_com_htzhu_protobuf_routeguice_RouteSummary_fieldAccessorTable;

	public static com.google.protobuf.Descriptors.FileDescriptor
	getDescriptor() {
		return descriptor;
	}

	private static com.google.protobuf.Descriptors.FileDescriptor
			descriptor;

	static {
		java.lang.String[] descriptorData = {
				"\n\021route_guide.proto\022\035com.htzhu.protobuf." +
						"routeguice\",\n\005Point\022\020\n\010latitude\030\001 \001(\005\022\021\n"
						+
						"\tlongitude\030\002 \001(\005\"o\n\tRectangle\0220\n\002lo\030\001 \001(" +
						"\0132$.com.htzhu.protobuf.routeguice.Point\022" +
						"0\n\002hi\030\002 \001(\0132$.com.htzhu.protobuf.routegu" +
						"ice.Point\"O\n\007Feature\022\014\n\004name\030\001 \001(\t\0226\n\010lo" +
						"cation\030\002 \001(\0132$.com.htzhu.protobuf.routeg" +
						"uice.Point\"J\n\017FeatureDatabase\0227\n\007feature" +
						"\030\001 \003(\0132&.com.htzhu.protobuf.routeguice.F" +
						"eature\"T\n\tRouteNote\0226\n\010location\030\001 \001(\0132$." +
						"com.htzhu.protobuf.routeguice.Point\022\017\n\007m" +
						"essage\030\002 \001(\t\"b\n\014RouteSummary\022\023\n\013point_co" +
						"unt\030\001 \001(\005\022\025\n\rfeature_count\030\002 \001(\005\022\020\n\010dist"
						+
						"ance\030\003 \001(\005\022\024\n\014elapsed_time\030\004 \001(\0052\235\003\n\nRou"
						+
						"teGuide\022\\\n\nGetFeature\022$.com.htzhu.protob" +
						"uf.routeguice.Point\032&.com.htzhu.protobuf" +
						".routeguice.Feature\"\000\022d\n\014ListFeatures\022(." +
						"com.htzhu.protobuf.routeguice.Rectangle\032" +
						"&.com.htzhu.protobuf.routeguice.Feature\"" +
						"\0000\001\022d\n\013RecordRoute\022$.com.htzhu.protobuf." +
						"routeguice.Point\032+.com.htzhu.protobuf.ro" +
						"uteguice.RouteSummary\"\000(\001\022e\n\tRouteChat\022(" +
						".com.htzhu.protobuf.routeguice.RouteNote" +
						"\032(.com.htzhu.protobuf.routeguice.RouteNo" +
						"te\"\000(\0010\001B8\n\035com.htzhu.protobuf.routeguic" +
						"eB\017RouteGuideProtoP\001\242\002\003RTGb\006proto3"
		};
		com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
				new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
					public com.google.protobuf.ExtensionRegistry assignDescriptors(
							com.google.protobuf.Descriptors.FileDescriptor root) {
						descriptor = root;
						return null;
					}
				};
		com.google.protobuf.Descriptors.FileDescriptor
				.internalBuildGeneratedFileFrom(descriptorData,
						new com.google.protobuf.Descriptors.FileDescriptor[]{
						}, assigner);
		internal_static_com_htzhu_protobuf_routeguice_Point_descriptor =
				getDescriptor().getMessageTypes().get(0);
		internal_static_com_htzhu_protobuf_routeguice_Point_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_com_htzhu_protobuf_routeguice_Point_descriptor,
				new java.lang.String[]{"Latitude", "Longitude",});
		internal_static_com_htzhu_protobuf_routeguice_Rectangle_descriptor =
				getDescriptor().getMessageTypes().get(1);
		internal_static_com_htzhu_protobuf_routeguice_Rectangle_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_com_htzhu_protobuf_routeguice_Rectangle_descriptor,
				new java.lang.String[]{"Lo", "Hi",});
		internal_static_com_htzhu_protobuf_routeguice_Feature_descriptor =
				getDescriptor().getMessageTypes().get(2);
		internal_static_com_htzhu_protobuf_routeguice_Feature_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_com_htzhu_protobuf_routeguice_Feature_descriptor,
				new java.lang.String[]{"Name", "Location",});
		internal_static_com_htzhu_protobuf_routeguice_FeatureDatabase_descriptor =
				getDescriptor().getMessageTypes().get(3);
		internal_static_com_htzhu_protobuf_routeguice_FeatureDatabase_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_com_htzhu_protobuf_routeguice_FeatureDatabase_descriptor,
				new java.lang.String[]{"Feature",});
		internal_static_com_htzhu_protobuf_routeguice_RouteNote_descriptor =
				getDescriptor().getMessageTypes().get(4);
		internal_static_com_htzhu_protobuf_routeguice_RouteNote_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_com_htzhu_protobuf_routeguice_RouteNote_descriptor,
				new java.lang.String[]{"Location", "Message",});
		internal_static_com_htzhu_protobuf_routeguice_RouteSummary_descriptor =
				getDescriptor().getMessageTypes().get(5);
		internal_static_com_htzhu_protobuf_routeguice_RouteSummary_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_com_htzhu_protobuf_routeguice_RouteSummary_descriptor,
				new java.lang.String[]{"PointCount", "FeatureCount", "Distance", "ElapsedTime",});
	}

	// @@protoc_insertion_point(outer_class_scope)
}